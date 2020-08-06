<template>
<div>
  <b-button v-b-modal.modal-1>Launch demo modal</b-button>

  <b-modal id="modal-1" title="BootstrapVue" size="lg">
    <p class="my-4">Hello from modal!</p>
    <div>
        <form class="container">
            <div class="row">
                <div>
                    <label for="title" class="col-md-5">Auto height:</label>
                    <div class="col-md-7">
                        <input type="text" id="title" v-model="boardData.subject">
                    </div>               
                </div>
            </div>
            <div class="row">
                <label for="content">content</label>
                <textarea name="" id="" cols="30" rows="10" style="resize:none;" v-model="boardData.content"></textarea>
            </div>
            <button @click="createBoard">submit</button>
        </form>
    </div>
  </b-modal>
</div>
</template>

<script>
import axios from 'axios'
import {sync} from 'vuex-pathify'

const API_URL = 'http://localhost:8080/'

export default {
    name: 'BoardCreate',

    computed: {
        curUid: sync('curUid')
    },

    data() {
        return {
            boardData: {
                uid: '',
                subject: '',
                content: '',
            }
        }
    },
    methods: {
        createBoard(){
            this.boardData.uid = this.curUid
            axios.post(`${API_URL}api/board/create/`, this.boardData)
            .then(res=>{
                this.$router.push('/')
            })
            .catch(err=> {
                console.log(err)
            })

        }
    },
    

}
</script>

<style>

</style>