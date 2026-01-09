<template>
  <div id="app">
    <h1>碳化管理系统</h1>

    <div class="section">
      <h3>碳化管理系统</h3>
      
      <el-button type="primary" @click="dialogVisible = true" style="margin-bottom: 15px;">
        + 新项目
      </el-button>

      <el-table :data="assetList" border stripe style="width: 100%">
        <el-table-column prop="assetId" label="Mã TS" width="80"></el-table-column>
        <el-table-column prop="assetType" label="Loại tài sản">
           <template slot-scope="scope">
             <span v-if="scope.row.assetType == '1'">Hạn ngạch (Quota)</span>
             <span v-else>Tín chỉ (Credit)</span>
           </template>
        </el-table-column>
        <el-table-column prop="amount" label="Số lượng (Tấn)"></el-table-column>
        <el-table-column prop="createTime" label="Ngày tạo"></el-table-column>
        <el-table-column prop="status" label="Trạng thái">
           <template slot-scope="scope">
              <el-tag type="warning" v-if="scope.row.status == '0'">Chờ duyệt</el-tag>
              <el-tag type="success" v-else>Đã duyệt</el-tag>
           </template>
        </el-table-column>
      </el-table>
    </div>

    <el-dialog title="Đăng ký Tài sản Carbon" :visible.sync="dialogVisible" width="500px">
      <el-form :model="form" label-width="120px">
        
        <el-form-item label="Loại tài sản">
          <el-select v-model="form.assetType" placeholder="Chọn loại">
            <el-option label="Hạn ngạch (Quota)" value="1"></el-option>
            <el-option label="Tín chỉ (Credit)" value="2"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="Số lượng (Tấn)">
          <el-input-number v-model="form.amount" :min="1"></el-input-number>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm">Xác nhận thêm</el-button>
          <el-button @click="dialogVisible = false">Hủy</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      assetList: [],
      dialogVisible: false, // Biến để ẩn/hiện cửa sổ nhập liệu
      form: {
        assetType: '1',
        amount: 100
      }
    }
  },
  mounted() {
    this.loadData();
  },
  methods: {
    loadData() {
      axios.get('http://localhost:9201/asset/list').then(res => {
        this.assetList = res.data;
      });
    },
    submitForm() {
      // Gửi dữ liệu form lên Backend
      axios.post('http://localhost:9201/asset/create', this.form)
        .then(() => {
          this.$message.success('Thêm mới thành công!');
          this.dialogVisible = false; // Đóng cửa sổ
          this.loadData(); // Tải lại bảng
        })
        .catch(err => {
          console.log(err);
          this.$message.error('Lỗi khi thêm mới!');
        });
    }
  }
}
</script>

<style>
#app { font-family: Arial, sans-serif; max-width: 900px; margin: 0 auto; padding: 20px; }
.section { padding: 20px; border: 1px solid #ddd; border-radius: 5px; margin-top: 20px;}
</style>
