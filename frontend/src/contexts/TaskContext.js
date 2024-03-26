import { createContext, useContext, useEffect, useReducer } from 'react'
import { useParams } from 'react-router-dom'
import { getBoardData } from './actions'

const TaskContext = createContext('context')

const initial = {}

//Handle actions
const reducer = (state, action) => {
  switch (action.type) {
    case 'UPDATE_BOARD_DATA': {
      return { ...action.payload }
    }
    default:
      throw new Error()
  }
}

const TaskContextProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initial)

  //Get the variable entered in the url
  const { id } = useParams()

  useEffect(() => {
    getBoardData(dispatch, id)
  }, [id])

  return (
    <TaskContext.Provider value={{ state, dispatch }}>
      {children}
    </TaskContext.Provider>
  )
}

export const useTaskContext = () => {
  const context = useContext(TaskContext)
  if (!context) {
    throw new Error('no context found')
  }
  return context
}

export { TaskContext, TaskContextProvider }
