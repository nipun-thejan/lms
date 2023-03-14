import { BrowserRouter, Routes, Route } from 'react-router-dom'
import { Register, Landing, Error, ProtectedRoute, Login } from './pages'
import {
  AllJobs,
  Profile,
  SharedLayout,
  Stats,
  AddJob,
  AdminRegister,
  AddCourse,
  AllCourse
} from './pages/dashboard'


function App() {
  return (
    <>
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<ProtectedRoute> <SharedLayout /></ProtectedRoute>}>
          <Route index element={<Stats />} />
          {/* <Route path='all' element={<AllJobs />} /> */}
          <Route path='add' element={<AddJob />} />
          <Route path='profile' element={<Profile />} />
          <Route path='/admin/register' element={<AdminRegister />} />
          <Route path='add_course' element={<AddCourse />} />
          <Route path='all_course' element={<AllCourse />} />



          </Route>
        <Route path='/register' element={<Register />} />
        <Route path='/landing' element={<Landing />} />
        <Route path='/login' element={<Login />} />
        <Route path='/*' element={<Error />} />
      </Routes>
    </BrowserRouter>
    <title>LMS</title>
    </>
    
  )
}

export default App
