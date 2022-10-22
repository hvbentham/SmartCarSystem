<template>
  <el-container style="min-height: 100vh">
    <el-aside width="sideWidth+'px'" style="background-color: rgb(238, 241, 246);min-height: 100vh;box-shadow: 2px 0 6px rgb(0 21 1.2)">
      <el-menu :default-openeds="['1', '3']" style="min-height: 100%" background-color="rgb(48,65,86)" text-color="#fff" :collapse="isCollapse" router>
        <div style="height: 40px; line-height: 60px;text-align: center;">
          <img src="../assets/logo.png" alt="" style="width: 20px; position: relative; top:5px;margin-right: 5px">
          智能小车仓库管理系统
<!--          fwfwef<b style="color: white" v-show="localTextShow">智能小车仓库管理系统</b>-->
        </div>
        <el-menu-item index="/home">
          <template slot="title">
            <i class="el-icon-house"></i>
          </template>
          <span slot="title">WareHouse</span>
        </el-menu-item>
        <el-submenu index="2" style="height: 100%">
          <template slot="title">
            <i class="el-icon-message"></i>
            <span slot="title" >SmartCar</span>
          </template>
          <el-menu-item-group>
            <template slot="title">Monitor
            </template>
            <el-menu-item index="/Manage">SmartCarManagement</el-menu-item>
            <!--              <el-menu-item index="1-2">选项2</el-menu-item>-->
          </el-menu-item-group>
        </el-submenu>
      </el-menu>

    </el-aside>

<!--    <el-container>-->
<!--      <el-header style=" font-size: 12px; border-bottom: 1px solid #ccc;line-height: 60px; display: flex">-->
<!--        <div style="flex: 1;font-size: 18px">-->
<!--          <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>-->
<!--        </div>-->
<!--        <el-dropdown  style="width: 70px; cursor: pointer">-->
<!--          <span>周睿萱</span><i class="el-icon-arrow-down"></i>-->
<!--          <el-dropdown-menu slot="dropdown">-->
<!--            <el-dropdown-item>个人信息</el-dropdown-item>-->
<!--            <el-dropdown-item>退出</el-dropdown-item>-->
<!--          </el-dropdown-menu>-->
<!--        </el-dropdown>-->
<!--      </el-header>-->

<!--      <el-main>-->
<!--        <div style="padding: 10px 0;">-->
<!--          <el-input style="width: 200px;" placeholder="number of the car" suffix-icon="el-icon-search"></el-input>-->
<!--          <el-input style="width: 200px;" placeholder="number of the shelf" suffix-icon="el-icon-takeaway-box" class="ml-5"></el-input>-->
<!--          <el-input style="width: 200px;" placeholder="number of the track" suffix-icon="el-icon-position" class="ml-5"></el-input><el-button class="ml-5" type="primary">搜索</el-button>-->
<!--        </div>-->
<!--        <div style="padding:10px 0">-->
<!--          <el-button type="primary" @click="load">Refresh<i class="el-icon-refresh-left"></i></el-button>-->
<!--          <el-button type="danger" @click="delT">Batch-delete<i class="el-icon-remove-outline"></i></el-button>-->
<!--          <el-button type="primary">import<i class="el-icon-bottom"></i></el-button>-->
<!--          <el-button type="primary">export<i class="el-icon-top"></i></el-button>-->
<!--        </div>-->
<!--        <el-table :data="tableData" border stripe>-->
<!--          <el-table-column prop="sno" label="Spotted-number" width="140">-->
<!--          </el-table-column>-->
<!--          <el-table-column prop="status" label="Status" width="140">-->
<!--          </el-table-column>-->
<!--          <el-table-column prop="time" label="Run-time" width="120">-->
<!--          </el-table-column>-->
<!--          <el-table-column prop="color" label="Color" width="120">-->
<!--          </el-table-column>-->
<!--          <el-table-column prop="position" label="Position">-->
<!--          </el-table-column>-->
<!--          <el-table-column>-->
<!--            <template slot-scope="scope">-->
<!--              <el-button type="warning">edit<i class="el-icon-edit"></i></el-button>-->
<!--              <el-button type="danger" @click="del(scope.row.sno)">delete<i class="el-icon-remove-outline"></i></el-button>-->
<!--            </template>-->
<!--          </el-table-column>-->
<!--        </el-table>-->
<!--        <div style="padding: 10px 0">-->
<!--          <el-pagination-->
<!--              @size-change="handleSizeChange"-->
<!--              @current-change="handleCurrentChange"-->
<!--              :current-page="pageNum"-->
<!--              :page-size="pageSize"-->
<!--              :page-sizes="[2,5,10,15,20]"-->
<!--              layout="total,sizes,prev,pager,next,jumper"-->
<!--              :total=total1-->
<!--          ></el-pagination>-->
<!--        </div>-->
<!--      </el-main>-->
<!--    </el-container>-->
  </el-container>
</template>

<script>
export default {
  name:"Aside"
}
</script>

<style scoped>

</style>
