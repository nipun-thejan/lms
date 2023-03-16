import { Outlet } from 'react-router-dom'
import Wrapper from '../../../assets/wrappers/SharedLayout'
import { Navbar, BigSidebar, SmallSidebar } from '../../../components'
import { useAppContext } from '../../../context/appContext';

const StudentSharedLayout = () => {
  const {user} = useAppContext();
    const role = user.role


  return (
    <Wrapper>
      <main className='dashboard'>
        <SmallSidebar />
        <BigSidebar />
        <div>
          <Navbar />
          <div className='dashboard-page'>
            <Outlet/>
          </div>
        </div>
      </main>
    </Wrapper>
  )
}

export default StudentSharedLayout
