<template>
  <div id="dashboard">
      <h1>Welcome Anne.</h1>
      <div class="columns">
        <div class="column">
          <positions-view></positions-view>
        </div>
      </div>
  </div>
</template>

<script>
import PositionsView from "./dashboard/PositionsView.vue";
import RequestsView from './dashboard/RequestsView.vue';
export default {
  data(){
    return{

    }
  },
  components: {
    PositionsView,
    RequestsView
  }
};
</script>

<style lang="css" scoped>
  .columns{
    padding-top: 20px;
  }
</style>
