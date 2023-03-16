
import axios from "axios";

class CourseService {
    async getAllCourses() {
        return axios.get("/course/all")
            .then(res => {
                res.data.forEach(u => {
                });
                return res.data;
            }).catch(err => {
                throw err;
            });
    }
    async search(query = "") {
        return axios.get(`/course/search?query=${query}`)
            .then(res => {
                res.data.forEach(u => {
                });
                return res.data;
            }).catch(err => {
                throw err;
            });
    }

    async getEnrolledStudents(token, courseId) {
        return axios.get(`/course/${courseId}/students`, {
            headers: {
                Authorization: `${token}`
            }
        }).then(res => {
            res.data.forEach(u => {
                res.data.push(u);
                res.data.pop(u);
            });
            return res.data;
        }).catch(err => {
            throw err;
        });
    }

}

let courseService = new CourseService();
export default courseService;