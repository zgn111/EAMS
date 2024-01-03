const actions = {
    async adminSelectAlbumCategory({commit}) {
        try {
            // 获取当前 URL 中的路径
            const currentPath = window.location.pathname;
            console.log(currentPath);
            // 定义匹配路径的正则表达式
            const regex = /\/admin\/albumCategory\/([^/]+)/;
            // 使用正则表达式进行匹配
            const match = currentPath.match(regex);

            if (match) {
                const name = decodeURIComponent(match[1]);
                const albumCategoryList = JSON.parse(localStorage.getItem("albumCategoryList"));
                const albumCategory = albumCategoryList.find(category => category.name === name);

                if (albumCategory) {
                    commit('setAdminSelectAlbumCategory', albumCategory);
                    console.log(albumCategory);
                }
            }
        } catch (error) {
            console.error('Error selecting album category:', error);
        }
    }
}


export default actions