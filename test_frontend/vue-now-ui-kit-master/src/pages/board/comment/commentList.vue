<template>
    <div class="row">
        <div class="col-md-12">
            <h6 class="text-muted mb-lg-3">{{uid}} {{date}}</h6>
            <p>{{content}}</p>
            <hr>
        </div>
    </div>
</template>

<script>
export default {
    name: 'commentList',
    data() {
        return {
            uid: 'username',
            content: 'content',
            date: 'date',
        }
    }
}
</script>

<style>

</style>