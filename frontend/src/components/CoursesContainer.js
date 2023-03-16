import { useAppContext } from '../context/appContext';
import { useEffect, useState } from 'react';
import Loading from './Loading';
import Job from './Job';
import Alert from './Alert';
import Wrapper from '../assets/wrappers/JobsContainer';
import PageBtnContainer from './PageBtnContainer';
import { Stats } from '../pages/dashboard';
import Course from './Course';
import courseService from '../service/CourseService';

const CoursesContainer = ({ courses }) => {
  const {
    isLoading,
    showAlert,
  } = useAppContext();
  // getCourses,
  // courses,
  // isLoading,
  // page,
  // totalCourses,
  // search,
  // searchStatus,
  // sort,
  // numOfPages,
  // showAlert

  if (isLoading) {
    return <Loading center />;
  }

  if (courses.length === 0) {
    return (
      <Wrapper>
        <h2>Nothing to display...</h2>
      </Wrapper>
    );
  }

  return (
    <Wrapper>
      {showAlert && <Alert />}
      <h5>
        {courses.length} course{courses.length > 1 && 's'} found
      </h5>
      <div className='jobs'>
        {courses.map((course, _id) => {
          return (
            <Course key={course._id} course={course} />
          )
        })}
      </div>
      {/* {numOfPages > 1 && <PageBtnContainer />} */}
    </Wrapper>
  );
};

export default CoursesContainer;
