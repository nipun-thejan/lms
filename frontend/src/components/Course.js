import moment from 'moment'
import { FaLocationArrow, FaBriefcase, FaCalendarAlt } from 'react-icons/fa'
import { Link } from 'react-router-dom'
import { useAppContext } from '../context/appContext'
import Wrapper from '../assets/wrappers/Job'
import JobInfo from './JobInfo'
import studentService from '../service/StudentService'
import localStorageService from '../service/LocalStorageService'

const Course = ({
  _id,
  createdAt,
  course,
  status
}) => {
  const { setEditJob, deleteJob } = useAppContext()
  const { name, course_code, description, conductor } = course
  // console.log(course)

  let date = moment(createdAt)
  date = date.format('MMM Do, YYYY')

  const token = localStorageService.getToken();

  const handleEnrollMe = () => {
    studentService.enroll(token, course.id).then(res => {
      console.log("enrolled")
    }).catch(err => {
      console.log(err);
    });
  }
  return (
    <Wrapper>
      <header>
        <div className='main-icon'>{name.charAt(0)}</div>
        <div className='info'>
          <h5>{name}</h5>
          <p>{course_code}</p>
        </div>
      </header>
      <div className='content'>
        <div className='content-center'>
          <JobInfo icon={<FaLocationArrow />} text={description} />
          <JobInfo icon={<FaCalendarAlt />} text={date} />
          <JobInfo icon={<FaBriefcase />} text={conductor.email} text_dis={"teacher email : "} />
          <JobInfo icon={<FaBriefcase />} text={conductor.firstName + " " + conductor.lastName} text_dis={"teacher name : "} />

          < div className={`status ${status}`}>{status}</div>
        </div>
        <footer>
          <div className='actions'>
            {/* <Link
              // to='/add-job'
              className='btn edit-btn'
            // onClick={() => setEditJob(_id)}
            >
              Edit
            </Link> */}
            {/* <button
              type='button'
              className='btn edit-btn'
              onClick={() => handleEnrollMe()}
            >
              Enroll
            </button> */}
          </div>
        </footer>
      </div>
    </Wrapper >
  )
}

export default Course
