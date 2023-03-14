import { admin_links, student_links, teacher_links } from '../utils/links';
import { NavLink } from 'react-router-dom';
import Wrapper from '../assets/wrappers/NavLinks';
import NavlinkDropdown from './NavlinkDropdown';
import { useAppContext } from '../context/appContext';

const NavLinks = ({ toggleSidebar }) => {
  const {user} = useAppContext();
  const role = user.role
  let links;
  if (role === "STUDENT") {
    links = student_links;
  } else if (role === "TEACHER") {
    links = teacher_links
  } else if (role === "ADMIN") {
    links = admin_links
  }
  
  return (
    <Wrapper>
      <div className='nav-links'>
        {links.map((link) => {
          const { text, path, id, icon } = link;

          return (
            <NavLink
              to={path}
              key={id}
              onClick={toggleSidebar}
              className={({ isActive }) =>
                isActive ? 'nav-link active' : 'nav-link'
              }
              end
            >
              <span className='icon'>{icon}</span>
              {text}
            </NavLink>
          );
        })}
        <NavlinkDropdown/>
      </div>
    </Wrapper>
  );
};

export default NavLinks;
