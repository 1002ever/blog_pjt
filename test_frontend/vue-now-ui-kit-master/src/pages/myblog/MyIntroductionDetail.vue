<template>
    <div>
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
                        <hr>
                    </div>
                </div>
            </div>
        </div>
    </div>

</template>

<script>

export default {
    name: 'MyIntroductionDetail',
    data() {
        return {
            title: 'title',
            uid : 'uesrname',
            date: 'date',
            content: 'content',
        }
    },
}
</script>

<style>

</style>