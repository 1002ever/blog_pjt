<template>
    <div class="container">
        <div class="row w-100">
            <div class="col-4" @drop="drop" @dragover="allowDrop" data-type="started">
                <div class="mt-5 align-center">제출전</div>
                <div
                    class="border mt-3 margin-center"
                    v-for="start in started"
                    :key="start.timelineno"
                    data-type="started"
                    draggable="true"
                    @dragstart="dragStart">{{start.tlname}}</div>
            </div>

            <div class="col-4" @drop="drop" @dragover="allowDrop" data-type="proceed">
                <div class="mt-5 align-center">진행중</div>
                <div
                    class="border mt-3 margin-center"
                    v-for="pro in proceed"
                    :key="pro.timelineno"
                    data-type="proceed"
                    draggable="true"
                    @dragstart="dragStart">{{pro.tlname}}</div>
            </div>

            <div class="col-4" @drop="drop" @dragover="allowDrop" data-type="finished">
                <div class="mt-5 align-center">제출완료</div>
                <div
                    class="border mt-3 margin-center"
                    v-for="finish in finished"
                    :key="finish.timelineno"
                    data-type="finished"
                    draggable="true"
                    @dragstart="dragStart">{{finish.tlname}}</div>
            </div>
        </div>
        <!-- Using components -->
        <div class="row align-items-center">
            <b-input-group prepend="회사추가" class="mt-3">
                <b-form-input class="inputform" v-model="inputTl"></b-form-input>
                <b-input-group-append>
                    <b-button variant="info" @click="updateRequest">Add</b-button>
                </b-input-group-append>
            </b-input-group>
        </div>
    </div>
</template>

<script>

    import axios from 'axios'
    import {sync} from 'vuex-pathify'

    export default {
        name: "DragDrop",
        data() {
            return {started: [], proceed: [], finished: [], datas: [], API_URL: '', inputTl: ''}
        },
        methods: {
            dragStart(event) {
                event
                    .dataTransfer
                    .setData("fromarray", event.target.dataset.type);
                event
                    .dataTransfer
                    .setData("fromindex", event.target.dataset.index);
            },
            allowDrop(event) {
                event.preventDefault();
            },
            drop(event) {
                event.preventDefault();
                var fromarray = event
                    .dataTransfer
                    .getData("fromarray");
                var fromindex = event
                    .dataTransfer
                    .getData("fromindex");
                var removed = this[fromarray].splice(fromindex, 1);
                var toarray = event.target.dataset.type;
                this[toarray].push(removed[0]);
            },
            callTimelineType0() {
                var url = `${this
                    .API_URL}/timeline/type/${this
                    .curUid}/0`
                    console
                    .log(url)
                axios
                    .get(url)
                    .then(res => {
                        this.started = res.data
                    })
                    .catch(err => {
                        console.log(err)
                    })
                },

            callTimelineType1() {
                axios
                    .get(`${this.API_URL}/timeline/type/${this.curUid}/1`)
                    .then(res => {
                        this.proceed = res.data

                    })
                    .catch(err => {
                        console.log(err)
                    })
                },

            callTimelineType2() {
                axios
                    .get(`${this.API_URL}/timeline/type/${this.curUid}/2`)
                    .then(res => {
                        console.log(res)
                        this.finished = res.data

                    })
                    .catch(err => {
                        console.log(err)
                    })
                },

            updateRequest() {
                if (this.inputTl === '') {
                    alert('추가할 회사명을 입력해주세요')
                    return
                }

                const url = `${this.API_URL}timeline/create`

                var requestBody = {
                    tlname: this.inputTl,
                    tltype: 0,
                    uid: this.curUid
                }

                console.log(url)
                console.log(requestBody)
                
                axios
                    .post(url, requestBody)
                    .then(res => {
                        console.log(res)
                        this.inputTl = ''
                        location.reload()
                        alert('작성되었습니다')
                    })
                    .catch((err) => {
                        console.log(err)
                        alert('저장하지 못했습니다')
                        return
                    })
                    this.callTimelineType0()
                }

        },

        computed: {
            curUid: sync('curUid'),
            DisURL: sync('DisURL'),
            LocalURL: sync('LocalURL'),
            isLocal: sync('isLocal')
        },
        created() {
            if (this.isLocal) {
                this.API_URL = this.LocalURL
            } else {
                this.API_URL = this.DisURL
            }

            this.callTimelineType0()
            this.callTimelineType1()
            this.callTimelineType2()
        }
    };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped="scoped">

    .align-center {
        text-align: center;
        padding: 10px 0;
        font-family: sans-serif, "맑은 고딕", serif;
        font-size: 24px;
        color: #010720;
        font-weight: bolder;
        border-radius: 10px;
        background-color: #FFEF99;
        height: 8vh;
    }
    .align-justify {
        text-align: justify;
    }
    .margin-center {
        margin-left: auto;
        margin-right: auto;
        height: 7vh;
        text-align: center;
        font-size: 20px;
        color: #0e0e0e;
        font-weight: bold;
        padding: 10px 0;
        border-radius: 10px;
        background-color: #F5F5F5;
        font-family: sans-serif, "맑은 고딕", serif;
    }
    .col-4 {
        height: 70vh;
        background-color: #735FE6;
        border-radius: 10px;
        border: 6px solid white;
    }
    .inputform{
        height:10hv;
    }
</style>