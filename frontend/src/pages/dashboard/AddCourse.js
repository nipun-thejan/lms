import { FormRow, FormRowSelect, Alert } from '../../components'
import { useAppContext } from '../../context/appContext'
import Wrapper from '../../assets/wrappers/DashboardFormPage'
import localStorageService from '../../service/LocalStorageService'
import { useState } from 'react'
import teacherService from '../../service/TeacherService'

const AddCourse = () => {
  const {
    isLoading,
    isEditing,
    showAlert,
    displayAlert,
    position,
    company,
    jobLocation,
    jobType,
    jobTypeOptions,
    status,
    statusOptions,
    handleChange,
    clearValues,
    createJob,
    editJob,
  } = useAppContext()
  const token = localStorageService.getToken();
  const [course, setCourse] = useState({
    name: "",
    description: "",
    course_code: ""
  });


  // const handleSubmit = (e) => {
  //   e.preventDefault()

  //   if (!position || !company || !jobLocation) {
  //     displayAlert()
  //     return
  //   }
  //   if (isEditing) {
  //     editJob()
  //     return
  //   }
  //   createJob()
  // }
  const resetForm = () => {
    setCourse({
      name: "",
      description: "",
      course_code: ""
    })
  }

  const addNewCourse = (e) => {
    e.preventDefault();
    console.log(course)
    teacherService.createNewCourse(token, course)
      .then(res => {
        resetForm()
      }).catch(err => {
        console.log(err)
      })
  }
  // const handleJobInput = (e) => {
  //   const name = e.target.name
  //   const value = e.target.value
  //   handleChange({ name, value })
  // }

  return (
    <Wrapper>
      <form className='form' onSubmit={addNewCourse}>
        {/* <h3>{isEditing ? 'edit course' : 'add course'}</h3> */}
        {showAlert && <Alert />}
        <div className='form-center'>
          {/* position */}
          <FormRow
            type='text'
            name='course name'
            value={course.name}
            handleChange={(e) => setCourse({ ...course, name: e.target.value })}
          />
          {/* company */}
          <FormRow
            type='text'
            name='course code'
            value={course.course_code}
            handleChange={(e) => setCourse({ ...course, course_code: e.target.value })}
          />
          {/* location */}

          {/* job status */}
          <FormRow
            type="text"
            name='course description'
            value={course.description}
            handleChange={(e) => setCourse({ ...course, description: e.target.value })}
          />

          {/* btn container */}
          <div className='btn-container'>
            <button
              type='submit'
              className='btn btn-block submit-btn'
              disabled={isLoading}
            >
              submit
            </button>
            <button
              className='btn btn-block clear-btn'
              onClick={(e) => {
                e.preventDefault()
                resetForm()
              }}
            >
              clear
            </button>
          </div>
        </div>
      </form>
    </Wrapper>
  )
}

export default AddCourse;
