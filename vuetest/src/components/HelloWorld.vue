<template>
  <div class="hello">
    <img src="../assets/logo.png">
    <router-link to="test"><h1>test</h1></router-link>
    <router-link to="login"><h1>login</h1></router-link>
    <router-link to="helloWorldTwo"><h1>helloWorldTwo</h1></router-link>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
