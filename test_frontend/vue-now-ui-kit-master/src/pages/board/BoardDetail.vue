<template>
    <div>
        <div class="page-header page-header-small">
            <parallax
                class="page-header-image"
                style="background-image: url('img/way1.jfif')"
            >
            </parallax>
            <div class="content-center">
                <div class="container">
                <h1 class="title">미남이의 블로그</h1>
                <div class="text-center"></div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row mt-5">
                <div class="col-md-12">
                    <h2 class="d-flex justify-content-center">{{boardData.subject}}</h2>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-9">
                        <p class="d-inline text-muted">{{boardData.uid}}</p>
                        <p class="d-inline text-muted ml-2">{{boardData.date}}</p>
                    </div>
                    <div class="col-sm-3 col-lg-3 d-flex justify-content-end">
                        <n-button type="primary" class="mt-0 mb-0 mr-2" round @click="BoardDelete">수정</n-button>
                        <n-button type="primary" class="mt-0 mb-0" round @click="BoardDelete">삭제</n-button>
                        </div>
                    <hr>
                </div>  
            </div>
            <div class="container">
                <div class="row mt-md-3">
                    <div class="col-md-12">
                        <p class="mt-md-2">
                            {{boardData.content}}
                        </p>
                        <br />
                        <br />
                <div class="row">
                    <div class="col-md-6">
                        <i class="now-ui-icons ui-2_favourite-28 text-danger p-1"></i>
                        <p class="d-inline-block text-muted pr-3"> {{boardData.likes}}</p>
                        <p class="d-inline-block text-muted">댓글 {{commentNumber}}</p>
                    </div>
                </div>        
                        <hr>
                    </div>
                </div>
            </div>
            <div class="container">
                <h4 class="text-muted mt-lg-1">댓글</h4>
                <commentList />
                <commentInput/>
            </div>

        </div>
    </div>

</template>

<script>
import axios from 'axios'
const API_URL = 'http://localhost:8080/'

import Button from '@/pages/board/comment/Button.vue'
import commentList from '@/pages/board/comment/commentList.vue'
import commentInput from '@/pages/board/comment/commentInput.vue'

export default {
    name: 'BoardDetail',
    data() {
        return {
            boardData: [],
            commentNumber: 'commentNumber',
        }
    },
    methods: {
        getBoardData(){
            const boardno = this.$route.params.boardno
            axios.get(`${API_URL}api/board/boardno/${boardno}/`)
            .then(res=>{
                this.boardData = res.data
            })
            .catch(err => {
                console.log(err)
            })
        },
        BoardDelete (){
            const boardno = this.$route.params.boardno
            axios.delete(`${API_URL}api/board/${boardno}/`)
            .then(res => {
                console.log(res)
                console.log(`${API_URL}api/board/${boardno}/`)
                this.$route.push('/')
            })
            .catch(err => {
                console.log(err)
            })
        }
    },
    created() {
        this.getBoardData()
    },
    components: {
        commentList,
        commentInput,
        [Button.name]: Button,
    },


}
</script>

<style>

</style>