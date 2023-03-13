import { useState, useEffect } from 'react';
import { Logo, FormRow, Alert } from '../components';
import Wrapper from '../assets/wrappers/LoginPage';
import { useAppContext } from '../context/appContext';
import { Link, useNavigate } from 'react-router-dom';
import FormikRow from '../components/FormikRow';
import { useFormik } from 'formik';
import * as Yup from 'yup'


const initialValues = {
  email: '',
  password: '',
};

const onSubmit = values => {
  console.log('Form data', values)
}

const validationSchema = Yup.object({
  email: Yup.string()
    .email('Invalid email format')
    .required('Required'),
  password: Yup.string().required('Required')
})

const Login = () => {
  const formikLogin = useFormik({
    initialValues,
    onSubmit,
    validationSchema
  })
  const navigate = useNavigate();
  const { loginUser,user, isLoading, showAlert, displayAlert, setupUser } =
    useAppContext();

  // const onSubmit = (e) => {
  //   e.preventDefault();
  //   const { email, password } = values;
  //   if (!email || !password ) {
  //     displayAlert();
  //     return;
  //   }
  //   const currentUser = { email, password };

  //   loginUser({
  //     currentUser,
  //     endPoint: '/auth/login',
  //     alertText: 'Login Successful!',
  //   });

  // };

  // useEffect(() => {
  //   if (user) {
  //     setTimeout(() => {
  //       navigate('/');
  //     }, 1000);
  //   }
  // }, [user, navigate]);

  return (
    <Wrapper className='full-page'>
      <form className='form' onSubmit={formikLogin.handleSubmit}>
        <Logo />
        <h3>Login</h3>
        {showAlert && <Alert />}

        <FormikRow
          type='email'
          name='email'
          value={formikLogin.values.email}
          onChange={formikLogin.handleChange}
          onBlur={formikLogin.handleBlur}
          touch={formikLogin.touched.email}
          err={formikLogin.errors.email}
        />
        {/* password input */}
        <FormikRow
          type='password'
          name='password'
          value={formikLogin.values.password}
          onChange={formikLogin.handleChange}
          onBlur={formikLogin.handleBlur}
          touch={formikLogin.touched.password}
          err={formikLogin.errors.password}
        />
        <button type='submit' className='btn btn-block' disabled={isLoading && !formikLogin.isValid}>
          submit
        </button>
        <p>
        Not a member yet?   <Link to="/register"> register</Link>
        </p>

      </form>
    </Wrapper>
  );
};
export default Login;
