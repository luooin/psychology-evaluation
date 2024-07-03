const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot/static/",
            name: "springboot",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "高校心理咨询系统的设计"
        } 
    }
}
export default base
