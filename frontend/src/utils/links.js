import { IoBarChartSharp } from 'react-icons/io5'
import { MdQueryStats } from 'react-icons/md'
import { FaWpbeginner, FaWpforms } from 'react-icons/fa'
import { ImProfile } from 'react-icons/im'
import { FaRegRegistered } from 'react-icons/fa'
import { MdLogin } from 'react-icons/md'

// const links = [
//   { id: 1, text: 'Home', path: '/', icon: <IoBarChartSharp /> },
//   { id: 2, text: 'all teachers', path: 'all', icon: <MdQueryStats /> },
//   { id: 3, text: 'add course', path: 'add', icon: <FaWpforms /> },
//   { id: 4, text: 'profile', path: 'profile', icon: <ImProfile /> },
//   { id: 5, text: 'register', path: 'admin/register', icon: <FaRegRegistered /> },
//   { id: 6, text: 'reg', path: '/admin/register', icon: <MdLogin /> }


// ]


const admin_links = [
  { id: 1, text: 'Home', path: '/', icon: <IoBarChartSharp /> },
  { id: 2, text: 'profile', path: 'profile', icon: <ImProfile /> },
  { id: 3, text: 'regsiter admin', path: 'admin/register', icon: <MdQueryStats /> },
  { id: 4, text: 'add course', path: 'add_course', icon: <FaWpforms /> },
  { id: 5, text: 'all course', path: 'all_course', icon: <FaWpforms /> },

]

const teacher_links = [
  { id: 1, text: 'Home', path: '/', icon: <IoBarChartSharp /> },
  { id: 2, text: 'profile', path: 'profile', icon: <ImProfile /> },
  { id: 3, text: 'all course', path: 'all_course', icon: <FaWpforms /> },
  { id: 4, text: 'add course', path: 'add_course', icon: <FaWpforms /> },

]

const student_links = [
  { id: 1, text: 'Home', path: '/', icon: <IoBarChartSharp /> },
  { id: 2, text: 'profile', path: 'profile', icon: <ImProfile /> },
  // { id: 3, text: 'add course', path: 'add_course', icon: <FaWpforms /> },
  { id: 3, text: 'all course', path: 'all_course', icon: <FaWpforms /> },

]
export { admin_links, student_links, teacher_links }
