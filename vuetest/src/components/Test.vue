<template>
    <div>
      <el-row>
        姓名：{{data.name}}
        <el-input v-model="data.name" placeholder="请输入姓名"></el-input>
        年龄：{{data.age}}
        <el-input v-model="data.age" placeholder="请输入年龄"></el-input>
        性别：{{data.sex}}
        <el-select v-model="data.sex" placeholder="请选择">
          <el-option v-for="item in options" :key="item" :value="item"></el-option><!-- 这里的key官方推荐在v-for时使用，不然会警告，但不影响使用 -->
        </el-select>
        <el-button @click="create">创建</el-button>
        <template>
          <el-table :data="tableData" align="left">
            <el-table-column prop="name" label="姓名"></el-table-column>
            <el-table-column prop="age" label="年龄"></el-table-column>
            <el-table-column prop="sex" label="性别"></el-table-column>
            <el-table-column label="操作">
              <template slot-scope="a">
                <el-button size="mini" type="danger" @click="del(a.$index)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </template>
      </el-row>
    </div>
</template>

<script>
  export default {
    name: 'Test',
    data() {
      return {
        data: {
          name: '',
          age: null,
          sex: ''
        },
        options: [
          '女', '男', '保密'
        ],
        tableData:[
          {name: 'Leo', age: 12, sex: 'man'},
          {name: 'Lei', age: 22, sex: 'women'},
          {name: 'Lii', age: 65, sex: 'men'}
        ]
      }
    },
    methods: {//添加在data(){...},的后面
      create() {
        this.tableData.push(this.data)//给tableData添加一个对象（之前我们创建的info）
        this.data = {name: '', age: null, sex: ''}//点击创建后，让option还原，而不是停留在所选的项
      },
      del(index) {
        this.tableData.splice(index, 1)//删除点击的对象，index是lot-scope="a" a.$index传过来的
      }
    }
  }
</script>

<style scoped>

</style>
