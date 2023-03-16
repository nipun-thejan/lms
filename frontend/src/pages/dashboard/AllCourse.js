import { useEffect, useState } from 'react'
import { JobsContainer, SearchContainer } from '../../components'
import CoursesContainer from '../../components/CoursesContainer'
import CourseSearchContainer from '../../components/CourseSearchContainer'
import courseService from '../../service/CourseService'
import Course from '../../components/Course'
import { useAppContext } from '../../context/appContext'
import localStorageService from '../../service/LocalStorageService'


const AllCourse = () => {
  const isSigned = localStorageService.isSigned();

  const {
    courses,
    getJobs
  } = useAppContext();

  return (
    <>
      <CourseSearchContainer />
      <CoursesContainer courses={courses} />

    </>
  )
}

export default AllCourse
