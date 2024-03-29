import axios from "axios";

class UserService {
    async getCurrentUserInfo(token) {
        return axios.get('/user/userInfo', {
            headers: {
                Authorization: `${token}`
            }
        }).then(res => {
            return res.data;
        }).catch(err => {
            throw err;
        })
    }
}

let userService = new UserService();
export default userService;