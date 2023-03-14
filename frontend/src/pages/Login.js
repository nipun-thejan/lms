import { useState, useEffect } from 'react';
import { Logo, FormRow, Alert } from '../components';
import Wrapper from '../assets/wrappers/LoginPage';
import { useAppContext } from '../context/appContext';
import { Link, useNavigate } from 'react-router-dom';
import FormikRow from '../components/FormikRow';
import { ErrorMessage, Field, Form, Formik, useFormik } from 'formik';
import * as Yup from 'yup'
import localStorageService from '../service/LocalStorageService';




const Login = () => {
  const isSigned = localStorageService.isSigned();

  const navigate = useNavigate();
  const { loginUser,user, isLoading, showAlert, token , setupUser} =
    useAppContext();

    const initialValues = {
      email: '',
      password: '',
    };
    
    const onSubmit = values => {
      // console.log("login", values)

      loginUser(values)
    
    }
    
    const validationSchema = Yup.object({
      email: Yup.string()
        .email('Invalid email format')
        .required('Required'),
      password: Yup.string().required('Required')
    })
    
  useEffect(() => {
    if (isSigned) {
      const localuser = {
        name : localStorageService.getName(),
        email: localStorageService.getEmail(),
        role: localStorageService.getRole()
      }
      const localtoken = localStorageService.getToken()
      // console.log(localuser)
      setupUser(localuser, localtoken )
    }
  }, [])

  useEffect(() => {
    if (user) {
      setTimeout(() => {
        navigate('/');
      }, 1000);
    }
  }, [user, navigate]);

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
        <Logo />
        <h3>Login</h3>
        {showAlert && <Alert />}

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
          
        <button type='submit' className='btn btn-block' disabled={isLoading && isSubmitting}>
          login
        </button>
        <p>
        Not a member yet?   <Link to="/register"> register</Link>
        </p>

      </Form>
          )
        }


      </Formik>
      
    </Wrapper>
  );
};
export default Login;
