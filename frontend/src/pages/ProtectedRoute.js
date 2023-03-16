import { useAppContext } from '../context/appContext';
import { Navigate } from 'react-router-dom';
import Loading from '../components/Loading';
const ProtectedRoute = ({ children }) => {
  const { user, userLoading } = useAppContext();

 

  if (!user) {
    return <Navigate to='/landing' />;
  }
  // if (user.role === 'ADMIN') {
    // 
  // }
  return children;
};

export default ProtectedRoute;
