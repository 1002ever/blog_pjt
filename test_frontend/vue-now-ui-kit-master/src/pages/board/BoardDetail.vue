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
                    <h2 class="d-flex justify-content-center">{{title}}</h2>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <p class="d-inline text-muted">{{uid}}</p>
                        <p class="d-inline text-muted ml-2">{{date}}</p>
                        <hr>
                    </div>
                </div>  
            </div>
            <div class="container">
                <div class="row mt-md-3">
                    <div class="col-md-12">
                        <p class="mt-md-2">
                            {{content}}
                            I will be the leader of a company that ends up being worth
                            billions of dollars, because I got the answers. I understand
                            culture. I am the nucleus. I think that’s a responsibility that
                            I have, to push possibilities, to show people, this is the level
                            that things could be at.
                        </p>
                        <br />
                        <br />
                <div class="row">
                    <div class="col-md-6">
                        <i class="now-ui-icons ui-2_favourite-28 text-danger p-1"></i>
                        <p class="d-inline-block text-muted pr-3"> {{likeNumber}}</p>
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
import commentList from '@/pages/board/comment/commentList.vue'
import commentInput from '@/pages/board/comment/commentInput.vue'

export default {
    name: 'BoardDetail',
    data() {
        return {
            title: 'title',
            uid : 'uesrname',
            date: 'date',
            content: 'content',
            likeNumber: 'likeNumber',
            commentNumber: 'commentNumber',


        }
    },
    components: {
        commentList,
        commentInput,
    }


}
</script>

<style>

</style>