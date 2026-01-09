import Vue from 'vue'
import App from './App.vue'
// Nhập thư viện giao diện ElementUI
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.config.productionTip = false

// Kích hoạt Element UI
Vue.use(ElementUI);

new Vue({
  render: h => h(App),
}).$mount('#app')
