import Wrapper from '../assets/wrappers/JobInfo'

const JobInfo = ({ icon, text, text_dis }) => {
  return (
    <Wrapper>
      <span className='icon'>{icon}</span>
      <span className='text'>{text_dis}</span>
      <span className='text'>{text}</span>
    </Wrapper>
  )
}

export default JobInfo
