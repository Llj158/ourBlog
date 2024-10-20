<template>
    <div>
        <h1>welcome to our blog{{ username }}</h1>
    </div>
</template>

<script>
export default {
    name: 'texte',
    data() {
        return {
            username: 'user1'

        }
    },
    mounted() {
        this.username=localStorage.getItem('username')
        
    },
    }
    </script>

    <style scoped>  


</style>