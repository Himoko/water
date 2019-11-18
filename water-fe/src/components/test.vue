<template>
  <div>
    <p>welcome to my house</p>
    <el-button @click="getInfo">查询member</el-button>
    <p>{{member}}</p>
    <el-button @click="getOrder">查询order</el-button>
    <p>{{order}}</p>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        member: {},
        order: {},
      }
    },
    methods: {
      getInfo() {
        const self = this;
        self.$http({
          method: 'GET',
          api: '/api/member/user/getUser',
        })
          .then(function(data) {
            self.member = data
          })
      },
      getOrder() {
        const self = this;
        self.$http({
          method: 'get',
          api: '/api/order/order/getOrder'
        })
          .then((data) => {
          self.order = data
        })
      }
    }
  }
</script>

<style scoped>

</style>
