import { Logo, Alert } from '../components';
import Wrapper from '../assets/wrappers/RegisterPage';
import { useAppContext } from '../context/appContext';
import { Link, useNavigate } from 'react-router-dom';
import FormikRo from '../components/FormikRow';
import * as Yup from 'yup'
import { ErrorMessage, Field, Form, Formik } from 'formik';



const Register = () => {
  const { user, isLoading, showAlert, displayAlert, registerUser } =
    useAppContext();

  const navigate = useNavigate();

    const initialValues = {
      firstName: '',
      lastName: '',
      email: '',
      password: '',
      confirmPassword: '',
      role: ''
    };
    
    const validationSchema = Yup.object({
      firstName: Yup.string().required('Required'),
      lastName: Yup.string().required('Required'),
      email: Yup.string()
        .email('Invalid email format')
        .required('Required'),
      password: Yup.string().required('Required'),
      confirmPassword: Yup.string()
        .oneOf([Yup.ref('password'), ''], 'Passwords must match')
        .required('Required'),  
      role: Yup.string()
      .oneOf(['STUDENT', 'TEACHER'], 'Invalid Role')
      .required('Role is required'),

      
    })
  

  const onSubmit = (values) => {
    const {firstName, email, lastName, password, role} = values
    const currentUser = {
      firstName, lastName, email, password, role}
    console.log("register", currentUser)

    registerUser(currentUser)
    navigate("/login")
  }

  return (
    <Wrapper className='full-page'>
      <Formik
      initialValues={initialValues}
      onSubmit={onSubmit}
      validationSchema={validationSchema}
      >
        {
          ({isSubmitting}) => (
          <Form className='form'>
      <Logo/>

        <h3>Register</h3>
        {showAlert && <Alert />}
        {/* name input */}
        
        {/* first name */}
        <div className='form-row'>
            <label className='form-label' htmlFor="firstName">First Name</label>
            <Field  className='form-input' type="text" id="firstName" name="firstName" />
            <ErrorMessage name="firstName" component="div" className="error" />
          </div>

          <div  className='form-row'>
            <label className='form-label' htmlFor="lastName">Last Name</label>
            <Field   className='form-input' type="text" id="lastName" name="lastName" />
            <ErrorMessage name="lastName" component="div" className="error" />
          </div>

          <div className='form-row'>
            <label className='form-label' htmlFor="email">Email</label>
            <Field  className='form-input' type="email" id="email" name="email" />
            <ErrorMessage name="email" component="div" className="error" />
          </div>

          <div  className='form-row'>
            <label className='form-label' htmlFor="password">Password</label>
            <Field  className='form-input' type="password" id="password" name="password" />
            <ErrorMessage name="password" component="div" className="error" />
          </div>

          <div  className='form-row'>
            <label className='form-label'  htmlFor="confirmPassword">Confirm Password</label>
            <Field  className='form-input' type="password" id="confirmPassword" name="confirmPassword" />
            <ErrorMessage name="confirmPassword" component="div" className="error" />
          </div>
        {/* {formik.touched.name && formik.errors.name ? (
          <div className='error'>{formik.errors.name}</div>
        ) : null} */}
        {/* role */}
        <div  className='form-label'>
            <label htmlFor="role">Role</label>
            <div>
              <label htmlFor="student" style={{'margin':'10px'}}>
                <Field style={{'margin':'10px'}} type="radio" id="student" name="role" value="STUDENT" />
                Student
              </label>
              <label htmlFor="teacher" >
                <Field style={{'margin':'10px'}} type="radio" id="teacher" name="role" value="TEACHER" />
                Teacher
              </label>
            </div>
            <ErrorMessage name="role" component="div" className="error" />
          </div>

        <button type='submit' 
        className='btn btn-block' 
        disabled={isLoading && isSubmitting}>
          register
        </button>
        {/* <button className='btn btn-block' type="submit" disabled={isSubmitting}>
            {isSubmitting ? 'Submitting...' : 'Submit'}
          </button> */}
        {/* <p>
          {values.isMember ? 'Not a member yet?' : 'Already a member?'}
          <button type='button' onClick={toggleMember} className='member-btn'>
            {values.isMember ? 'Register' : 'Login'}
          </button>
        </p> */}
        <p>
          Already a member?   <Link to="/login"> login</Link>
        
        </p>
      </Form>
  )
          
        }
      </Formik>
      
      
    </Wrapper>
  );
};
export default Register;
