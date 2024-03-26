import './App.css'
import { Board } from './components/index'
import { TaskContextProvider } from './contexts/TaskContext'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import Error from './Error.js'

function App() {
  if (localStorage.getItem('history') !== null) {
    if (Array.isArray(JSON.parse(localStorage.getItem('history')))) {
      if (localStorage.getItem('history').length > 0) {
        let temp = [...JSON.parse(localStorage.getItem('history'))]
        temp.push(window.location.href)
        localStorage.setItem('history', JSON.stringify(temp))
      } else {
        localStorage.setItem('history', JSON.stringify([window.location.href]))
      }
    } else {
      localStorage.clear()
      localStorage.setItem('history', JSON.stringify([window.location.href]))
    }
  } else {
    localStorage.setItem('history', JSON.stringify([window.location.href]))
  }
  return (
    <Router>
      <Routes>
        <Route
          path="/:id"
          element={
            <TaskContextProvider>
              <Board />
            </TaskContextProvider>
          }
        />
        <Route path="/*" element={<Error />} />
      </Routes>
    </Router>
  )
}

export default App
