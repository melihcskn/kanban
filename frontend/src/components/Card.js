import React, { useRef, useState } from 'react'
import { Draggable } from '@hello-pangea/dnd'
import TextareaAutosize from 'react-textarea-autosize'
import { useTaskContext } from '../contexts/TaskContext'
import './components.css'
import { saveTask, deleteTask } from '../contexts/index'

export default function Card(props) {
  const { item } = props
  const { dispatch } = useTaskContext()
  const [textValue, setTextValue] = useState(item.taskDescription)
  const defaulTextValue = useRef(item.taskDescription)

  const postCard = (e) => {
    //Dont post if the text has not changed
    if (defaulTextValue.current !== textValue) {
      item.taskDescription = textValue
      saveTask(item, dispatch)
    }
  }

  return (
    <Draggable draggableId={item.taskId.toString()} index={props.index}>
      {(provided, snapshot) => {
        return (
          <div
            onDoubleClick={(e) => {
              deleteTask(item, dispatch)
            }}
            ref={provided.innerRef}
            {...provided.draggableProps}
            {...provided.dragHandleProps}
            className="card"
            style={{
              ...provided.draggableProps.style,
              backgroundColor: item.taskColor,
            }}
          >
            <TextareaAutosize
              value={textValue}
              onChange={(e) => {
                setTextValue(e.target.value)
              }}
              onBlur={(e) => {
                postCard(e)
              }}
              className="card__textArea"
            />
          </div>
        )
      }}
    </Draggable>
  )
}
