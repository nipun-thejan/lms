
import axios from "axios";

class TeacherService {

    async createNewCourse(token, course) {
        return axios.post("/course/create", course, {
            headers: {
                Authorization: `${token}`
            }
        }).then(res => {
            return res.data
        }).catch(err => {
            throw err;
        })
    }
}

let teacherService = new TeacherService();
export default teacherService;