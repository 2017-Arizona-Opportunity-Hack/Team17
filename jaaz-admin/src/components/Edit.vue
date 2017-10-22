<template>
  <div id="edit">
      <div class="field">
      <label class="label">School Name</label>
      <div class="control">
        <input v-model="name" class="input" type="text" placeholder="Name">
      </div>
    </div>
    
    <div class="field">
      <label class="label">Address</label>
      <div class="control">
        <input v-model="address" class="input" type="text" placeholder="Address">
      </div>
    </div>

    <div class="field">
      <label class="label">City</label>
      <div class="control">
        <input v-model="city" class="input" type="text" placeholder="City">
      </div>
    </div>

    <div class="field">
      <label class="label">County</label>
      <div class="control">
        <input v-model="county" class="input" type="text" placeholder="County">
      </div>
    </div>

    <div class="field">
      <label class="label">ZIP</label>
      <div class="control">
        <input v-model="zip" class="input" type="number" placeholder="ZIP">
      </div>
    </div>

    <div class="field is-grouped">
      <div class="control">
        <button v-on:click="onSubmit" class="button is-link">Submit</button>
      </div>
      <div class="control">
        <button class="button is-text">Cancel</button>
      </div>
    </div>
  </div>
</template>

<script>
import * as firestore from "../firebase/firebase.js";
let positions = firestore.positionsCollection;
export default {
  data(){
    return{
      name: '',
      address: '',
      city: '',
      county: '',
      zip: 0
    }
  },
  methods: {
    onSubmit(){
      console.log("Submitting...");
      positions.add({
          name: this.name,
          address: this.address,
          city: this.city,
          county: this.county,
          zip: this.zip
      })
      .then(function(docRef) {
          console.log("Document written with ID: ", docRef.id);
      })
      .catch(function(error) {
          console.error("Error adding document: ", error);
      });
    }
  }
};
</script>

<style lang="sass" scoped>

</style>
