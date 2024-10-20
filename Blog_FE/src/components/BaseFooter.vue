<template>
  <el-footer class="me-area">
    <div class="me-footer">
      <h3>
        2024 © OurBlog. by zxj&&tw
      </h3>
      <p>

      </p>
    </div>
  </el-footer>
</template>

<script>

export default {
  name: 'BaseFooter',
  data() {
    return {}
  },
  methods: {},
  mounted() {
  }
}
</script>

<style>
.el-footer {
  min-width: 100%;
  box-shadow: 0 -2px 3px hsla(0, 0%, 7%, .1), 0 0 0 1px hsla(0, 0%, 7%, .1);
  position: absolute;
  bottom: 0;
  left: 0;
  z-index: 1024;
}

.me-footer {
  text-align: center;
  line-height: 60px;
  font-family: 'Open Sans', sans-serif;
  color: gray;
  font-size: 14px;

}

.me-login-design-color {
  color: #5FB878 !important;
}
</style>
