import Wrapper from '../assets/wrappers/Navbar'
import { FaAlignLeft, FaUserCircle, FaCaretDown } from 'react-icons/fa'
import { useAppContext } from '../context/appContext'
import Logo from './Logo'
import { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'


const Navbar = () => {

  const [showLogout, setShowLogout] = useState(false)
  const { toggleSidebar, logoutUser, user } = useAppContext()
  const navigate = useNavigate();

  useEffect(() => {
    if (user) {
      setTimeout(() => {
        navigate('/');
      }, 1000);
    }
  }, [user]);
  return (
    <Wrapper>
      <div className='nav-center'>
        <button type='button' className='toggle-btn' onClick={toggleSidebar}>
          <FaAlignLeft />
        </button>
        <div>
          {/* <Logo /> */}
          <h3 className='logo-text'>Learn Management System</h3>
        </div>
        <div className='btn-container'>
          <button
            type='button'
            className='btn'
            onClick={() => setShowLogout(!showLogout)}
          >
            <FaUserCircle />
            {user?.firstName + " " + user?.lastName || "user"} - {user?.role || "role"}
            <FaCaretDown />
          </button>
          <div className={showLogout ? 'dropdown show-dropdown' : 'dropdown'}>
            <>
              <button type='button' className='dropdown-btn' onClick={logoutUser}>
                logout
              </button>
            </>
            {/* <button type='button' className='dropdown-btn' onClick={logoutUser}>
              l
            </button> */}

          </div>
        </div>
      </div>
    </Wrapper>
  )
}

export default Navbar
