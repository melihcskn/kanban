import React from 'react'
import { Card } from './index'
import { Droppable } from '@hello-pangea/dnd'
import './components.css'
import { useTaskContext } from '../contexts/TaskContext'
import { GridColumn } from 'semantic-ui-react'

export default function TaskList({ id, name }) {
  const { state } = useTaskContext()
  const tasks = structuredClone(state)
  const list = tasks.boardData[id].taskList

  return (
    <div style={{ margin: '1rem', textAlign: 'center' }}>
      <Droppable droppableId={id.toString()}>
        {(provided, snapshot) => {
          return (
            <GridColumn>
              <div
                {...provided.droppableProps}
                ref={provided.innerRef}
                className="taskList"
                style={{
                  background: snapshot.isDraggingOver ? 'lightblue' : '#232124',
                }}
              >
                <h2>{name}</h2>
                {list.map((item, index) => {
                  return <Card key={item.taskId} index={index} item={item} />
                })}
                {provided.placeholder}
              </div>
            </GridColumn>
          )
        }}
      </Droppable>
    </div>
  )
}
