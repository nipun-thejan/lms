import { useAppContext } from "../../context/appContext"


const Dashboard = () => {
    const {user} = useAppContext();
    const role = user.role

    return (
        <>
        <div>
        {role === "MANAGEMENT_STAFF" && <AdminDash token={token} />}
        {role === "TEACHER" && <TeacherDashboard token={token} />}
        {role === "STUDENT" && <StudentDashboard token={token} />}
        </div>
        
        
        
        </>
    )

}