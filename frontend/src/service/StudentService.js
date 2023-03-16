
import axios from "axios";

class StudentService {

    async enroll(token, courseId) {
        return axios.post(`/course/enroll/${courseId}`, {}, {
            headers: {
                Authorization: `${token}`
            }
        }).then(res => {
            return res.data;
        }).catch(err => {
            throw err;
        })
    }

    async unenroll(token, courseId) {
        return axios.post(`/course/unenroll/${courseId}`, {}, {
            headers: {
                Authorization: `${token}`
            }
        }).then(res => {
            return res.data;
        }).catch(err => {
            throw err;
        })
    }
    async getEnrolledCourses(token) {
        return axios.get('/student/courses', {
            headers: {
                Authorization: `${token}`
            }
        }).then(res => {
            return res.data;
        }).catch(err => {
            throw err;
        });
    }


}

const studentService = new StudentService();
export default studentService;





































//     async isEnrolledForCourse(token, courseId) {
//         return this.getEnrolledCourses(token)
//             .then(res => {
//                 let x = res.find(course => { return course.id === courseId });
//                 return x !== undefined;
//             }).catch(err => {
//                 throw err;
//             })
//     }
