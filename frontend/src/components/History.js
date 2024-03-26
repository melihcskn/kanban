import React, { useState } from 'react'
import './components.css'
import { Link } from 'react-router-dom'
import { Button } from 'semantic-ui-react'

export default function History() {
  const [history, setHistory] = useState(
    JSON.parse(localStorage.getItem('history'))
  )

  const ResetHistory = () => {
    localStorage.setItem('history', JSON.stringify([]))
    setHistory([])
  }

  return (
    <div className="board__history">
      <h2>History</h2>
      {history.map((link, index) => {
        return (
          <div
            key={index}
            style={{
              padding: '1rem',
              border: 'none',
              backgroundColor: '#232124',
            }}
          >
            <Link to={link} className="board__history__link">
              {link}
            </Link>
          </div>
        )
      })}
      <Button
        primary
        style={{ marginTop: '2rem' }}
        onClick={(e) => {
          ResetHistory()
        }}
      >
        Reset History
      </Button>
    </div>
  )
}
