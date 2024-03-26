import { taskURL, getBoardByBoardIdURL } from '../contants'
import axios from 'axios'

async function getBoardData(dispatch, boardId) {
  try {
    const getBoardURL = getBoardByBoardIdURL.concat(boardId)
    var boardData = await axios.get(getBoardURL)
    dispatch({ type: 'UPDATE_BOARD_DATA', payload: convert(boardData.data) })
  } catch (error) {
    dispatch({ type: 'UPDATE_BOARD_DATA', payload: [] })
    console.log(error)
  }
}

async function addTask(dispatch, boardId) {
  try {
    const newTask = {
      taskDescription: 'New task',
      taskId: Math.floor(Math.random() * 1000),
      statusId: 0,
      taskColor: 'red',
      boardId: boardId,
    }

    const addTaskURL = taskURL
    await axios.post(addTaskURL, newTask)

    getBoardData(dispatch, boardId)
  } catch (error) {
    console.log(error)
  }
}

async function saveTask(task, dispatch) {
  const saveTaskURL = taskURL.concat(task.taskId)
  try {
    await axios.put(saveTaskURL, task)
    getBoardData(dispatch, task.boardId)
  } catch (error) {
    console.log(error)
  }
}

async function deleteTask(task, dispatch) {
  try {
    const deleteTaskURL = taskURL.concat(task.taskId)
    await axios.delete(deleteTaskURL)

    getBoardData(dispatch, task.boardId)
  } catch (error) {
    console.log(error)
  }
}

async function handleDragDrop(result, task, dispatch) {
  const { source, destination } = result

  const tempTask = {
    ...task.boardData[source.droppableId].taskList[source.index],
  }
  tempTask.statusId = destination.droppableId

  saveTask(tempTask, dispatch)
}

//Handle task indexes in the same status
function changeIndex(result, taskData, dispatch) {
  const { source, draggableId, destination } = result

  const temp = structuredClone(
    taskData.boardData[source.droppableId].taskList.filter((item, index) => {
      return item.taskId.toString() === draggableId
    })
  )
  if (temp) {
    taskData.boardData[source.droppableId].taskList.splice(source.index, 1)
    taskData.boardData[source.droppableId].taskList.splice(
      destination.index,
      0,
      temp[0]
    )
  }

  //Update task data
  dispatch({
    type: 'UPDATE_BOARD_DATA',
    payload: taskData,
  })
}

//Convert fetched board data into hierarchical order
const convert = function (boardData) {
  let data = structuredClone(boardData)
  // eslint-disable-next-line
  data.statusData.map((item, index) => {
    const temp = data.taskList.filter((task) => {
      return task.statusId === item.statusId
    })
    data.statusData[index] = {
      ...data.statusData[index],
      taskList: [...temp],
    }
  })
  data = { boardId: data.boardId, boardData: [...data.statusData] }
  return data
}

export {
  getBoardData,
  addTask,
  deleteTask,
  handleDragDrop,
  saveTask,
  changeIndex,
}
