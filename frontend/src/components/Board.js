import { TaskList, History } from './index'
import './components.css'
import { DragDropContext } from '@hello-pangea/dnd'
import { useTaskContext } from '../contexts/TaskContext'
import { useParams } from 'react-router-dom'
import { Button, Grid, GridRow } from 'semantic-ui-react'
import { handleDragDrop, addTask, changeIndex } from '../contexts/index'

//Drag operations for tasks
const onDragEnd = (result, taskData, dispatch) => {
  if (!result.destination) return

  const { source, destination } = result

  //If task index or status doesn't change no need for any operation
  if (
    source.index === destination.index &&
    source.droppableId === destination.droppableId
  )
    return

  if (source.droppableId !== destination.droppableId) {
    handleDragDrop(result, taskData, dispatch)
  } else {
    changeIndex(result, taskData, dispatch)
  }
}

const addNewTask = (dispatch, boardId) => {
  addTask(dispatch, boardId)
}

export default function Board() {
  const { state, dispatch } = useTaskContext()
  const { id: boardId } = useParams()

  //Since our array also contains array we cant use
  //commonly used other methods such as spread, slice, array.from etc...
  //so we use structuredClone to prevent our copy array to change original object
  const tasks = structuredClone(state)

  return Object.keys(tasks).length > 0 ? (
    <div style={{ textAlign: 'center' }}>
      <div className="board__list">
        <DragDropContext
          onDragEnd={(result) => onDragEnd(result, tasks, dispatch)}
        >
          <Grid columns={4}>
            <GridRow>
              {tasks.boardData.map((item, index) => {
                return (
                  <TaskList
                    id={item.statusId}
                    key={item.statusId}
                    name={item.statusName}
                  />
                )
              })}
            </GridRow>
          </Grid>
        </DragDropContext>
      </div>
      <Button
        primary
        style={{ marginTop: '2rem' }}
        onClick={(e) => addNewTask(dispatch, boardId)}
      >
        Add new task
      </Button>
      <History />
    </div>
  ) : (
    <div>Wrong board id or connection error</div>
  )
}
