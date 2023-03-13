import { Logo, Alert } from '../components';
import Wrapper from '../assets/wrappers/RegisterPage';
import { useAppContext } from '../context/appContext';
import { Link, useNavigate } from 'react-router-dom';
import Tab from 'react-bootstrap/Tab';
import Tabs from 'react-bootstrap/Tabs';
import FormikRow from '../components/FormikRow';
import * as Yup from 'yup'
import { useFormik } from 'formik';


const initialValues = {
  firstName: '',
  lastName: '',
  email: '',
  password: '',
  confirmPassword: '',
  role: ''
};
const onSubmit = values => {
  console.log('Form data', values)
}

// const onSubmit = values => {
//   e.preventDefault();
//   const { firstName, lastName, email, password, role } = values;
//   // if (!email || !password) {
//   //   displayAlert();
//   //   return;
//   // }
//   const currentUser = { email, password };
//   console.log(currentUser)
//   registerUser({
//     currentUser,
//     endPoint: 'auth/register',
//     alertText: 'User Created',
//   });
// }

const validationSchema = Yup.object({
  firstName: Yup.string().required('Required'),
  lastName: Yup.string().required('Required'),
  email: Yup.string()
    .email('Invalid email format')
    .required('Required'),
  password: Yup.string().required('Required'),
  confirmPassword: Yup.string()
    .oneOf([Yup.ref('password'), ''], 'Passwords must match')
    .required('Required')
})



const Register = () => {
  const formik = useFormik({
    initialValues,
    onSubmit,
    validationSchema
  })

  const navigate = useNavigate();

  const { user, isLoading, showAlert, displayAlert, registerUser } =
    useAppContext();


  return (
    <Wrapper className='full-page'>
      
      <form className='form' onSubmit={formik.handleSubmit}>
      <Logo/>

        <h3>Register</h3>
        {showAlert && <Alert />}
        {/* name input */}
        
        {/* first name */}
        <FormikRow
          type='text'
          labelText="First Name"
          name='firstName'
          value={formik.values.firstName}
          onChange={formik.handleChange}
          onBlur={formik.handleBlur}
          touch={formik.touched.firstName}
          err={formik.errors.firstName}
        />
        {/* lastname */}
        <FormikRow
          type='text'
          name='lastName'
          labelText="Last Name"
          value={formik.values.lastName}
          onChange={formik.handleChange}
          onBlur={formik.handleBlur}
          touch={formik.touched.lastName}
          err={formik.errors.lastName}
        />

        {/* email input */}
        <FormikRow
          type='email'
          name='email'
          value={formik.values.email}
          onChange={formik.handleChange}
          onBlur={formik.handleBlur}
          touch={formik.touched.email}
          err={formik.errors.email}
        />

        {/* password input */}
        <FormikRow
          type='password'
          name='password'
          value={formik.values.password}
          onChange={formik.handleChange}
          onBlur={formik.handleBlur}
          touch={formik.touched.password}
          err={formik.errors.password}
        />
        <FormikRow
          type='password'
          name='confirmPassword'
          value={formik.values.confirmPassword}
          onChange={formik.handleChange}
          onBlur={formik.handleBlur}
          touch={formik.touched.confirmPassword}
          err={formik.errors.confirmPassword}
        />
        {/* {formik.touched.name && formik.errors.name ? (
          <div className='error'>{formik.errors.name}</div>
        ) : null} */}
        {/* role */}

        <button type='submit' className='btn btn-block' disabled={isLoading && !formik.isValid}>
          submit
        </button>
        {/* <p>
          {values.isMember ? 'Not a member yet?' : 'Already a member?'}
          <button type='button' onClick={toggleMember} className='member-btn'>
            {values.isMember ? 'Register' : 'Login'}
          </button>
        </p> */}
        <p>
          Already a member?   <Link to="/login"> login</Link>
        
        </p>
      </form>
    </Wrapper>
  );
};
export default Register;
