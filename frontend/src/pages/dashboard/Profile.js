import { useState } from 'react'
import { FormRow, Alert } from '../../components'
import { useAppContext } from '../../context/appContext'
import Wrapper from '../../assets/wrappers/DashboardFormPage'
const Profile = () => {
  const { user, showAlert, displayAlert, updateUser, isLoading } =
    useAppContext()

  const [firstName, setFirstName] = useState(user?.firstName)
  const [lastName, setLastName] = useState(user?.lastName)
  const [email, setEmail] = useState(user?.email)
  const [role, setRole] = useState(user?.role)

  console.log(user)

  const handleSubmit = (e) => {
    e.preventDefault()
    if (!firstName || !email || !role || !lastName) {
      displayAlert()
      return
    }
    updateUser({ firstName, lastName, email, role })
  }

  return (
    <Wrapper>
      <form className='form' onSubmit={handleSubmit}>
        <h3>profile</h3>
        {showAlert && <Alert />}
        <div className='form-center'>
          <FormRow
            type='text'
            name='first name'
            value={firstName}
          // handleChange={(e) => setFirstName(e.target.value)}
          />
          <FormRow
            type='text'
            name='last name'
            value={lastName}
          // handleChange={(e) => setLastName(e.target.value)}
          />

          <FormRow
            type='text'
            labelText='role'
            name='role'
            value={role}
          // handleChange={(e) => setRole(e.target.value)}
          />
          <FormRow
            type='email'
            name='email'
            value={email}
            // handleChange={(e) => setEmail(e.target.value)}
            disabled
          />
          {/* <FormRow
            type='text'
            name='location'
            value={location}
            handleChange={(e) => setLocation(e.target.value)}
          /> */}
          <button className='btn btn-block' type='submit' disabled={isLoading}>
            {isLoading ? 'Please Wait...' : 'save changes'}
          </button>
        </div>
      </form>
    </Wrapper>
  )
}

export default Profile
