<template>
  <div id="positions">
    <h3>Positions Available</h3>
    <router-link to="/edit"><button class="button is-success">Add</button></router-link>
    <div class="position-list">
        <div class="position-item" v-for="position in positionsList">
          <div class="columns">
            <div class="column">
              <p>{{ position.name }}</p>
            </div>
            <div class="column text-right">
              <p>{{ position.city }}</p>
            </div>
          </div>
          <div class="columns">
            <div class="column">
              <p>Elementary, Middle School</p>
            </div>
            <div class="column text-right">
              <img @click="deleteItem(position)" src="../../assets/trash.svg" class="icon">
            </div>
          </div>
        </div>
    </div>
  </div>
</template>

<script>
import * as firestore from "../../firebase/firebase.js";
let positions = firestore.positionsCollection;
let users = firestore.usersCollection;

export default {
  data(){
    return{
    positionsList: []
    }
  },
  methods: {
    deleteItem(position){
      console.log(position);
      let id = position.itemID;
      console.log('Deleting ' + id);
      let deleteDoc = positions.doc(id).delete();
    }
  },
  mounted(){
    let _this = this;
    positions.get()
    .then((snapshot) => {
        snapshot.forEach((doc) => {
          let tmpData = doc.data();
          tmpData.itemID = doc.id;
          console.log(tmpData);
           _this.positionsList.push(tmpData);
        });
    })
    .catch((err) => {
        console.log('Error getting documents', err);
    });
    console.log(this.positionsList);
  }
};
</script>

<style lang="css" scoped>
.position-list{
  display: flex;
  justify-content: center;
}
.position-item {
  border: solid 1px black;
  margin: 10px 0;
  padding: 5px;
  border-radius: 5px;
  width: 500px;
}
.text-right {
  text-align: right;
}
img.icon{
  cursor: pointer;
  transition: 500ms;
}
img.icon:hover{
  color: green;
}
.is-success{
  text-align: center;
  margin: 0 auto;
  display: block;
}
</style>
