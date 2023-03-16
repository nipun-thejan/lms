import { Outlet } from 'react-router-dom'
import Wrapper from '../../../assets/wrappers/SharedLayout'
import { Navbar, BigSidebar, SmallSidebar } from '../../../components'
import { useAppContext } from '../../../context/appContext';
import StudentSharedLayout from './StudentSharedLayout';
import TeacherSharedLayout from './TeacherSharedLayout';
import AdminSharedLayout from './AdminSharedLayout';

const SharedLayout = () => {
  const {user} = useAppContext();
  const role = user?.role || null;


  return (
    // <Wrapper>
    //   <main className='dashboard'>
    //     <SmallSidebar />
    //     <BigSidebar />
    //     <div>
    //       <Navbar />
    //       <div className='dashboard-page'>
    //         <Outlet/>
    //       </div>
    //     </div>
    //   </main>
    // </Wrapper>
    <>
        {role === "STUDENT" && <StudentSharedLayout/>}
        {role === "TEACHER" && <TeacherSharedLayout/>}
        {role === "ADMIN" && <AdminSharedLayout/>}
     </>
  )
}

export default SharedLayout
