<script setup lang="ts">
import { ref } from 'vue'

const title = "lovelyform"
const images = [
  '/carousel/image0.jpg',
  '/carousel/image1.jpg',
  '/carousel/image2.jpg'
]
const currentSlide = ref(0)
</script>

<template>
  <v-main class="bg-brown">
    <div class="mobile-viewport">
      <!-- Profile Image -->
      <div class="text-center" style="margin-top: 80px;">
        <v-avatar size="100" class="mb-4">
          <v-img src="/avatar.jpeg" alt="Profile"/>
        </v-avatar>
        <h1 class="profile-title">{{ title }}</h1>
        <a 
          href="https://instagram.com/lovely.form" 
          target="_blank" 
          class="mt-2 instagram-link"
        >
          <v-icon color="white" size="36">mdi-instagram</v-icon>
        </a>
      </div>
      
      <!-- Image Carousel -->
      <div class="carousel-container">
        <v-carousel 
          v-model="currentSlide"
          height="auto"
          hide-delimiter-background
          show-arrows="hover"
          class="carousel"
        >
          <v-carousel-item
            v-for="(image, index) in images"
            :key="index"
            :src="image"
            contain
          />
        </v-carousel>
      </div>
    </div>
  </v-main>
</template>

<style scoped>
.bg-brown {
  background: #9a7960;
  min-height: 100vh;
  width: 100vw;
  position: fixed;
  top: 0;
  left: 0;
  display: flex;
  justify-content: center;
  align-items: flex-start;
  padding-top: 40px;
  overflow: hidden;
}

.mobile-viewport {
  width: 634px;
  height: calc(100vh - 80px);
  background: #af957e;
  border-radius: 20px;
  overflow: hidden;
}

@media (max-width: 768px) {
  .mobile-viewport {
    width: 100vw;
    height: 100vh;
    border-radius: 0;
  }
  
  .bg-brown {
    padding-top: 0;
  }
}

.profile-title {
  color: white;
  font-size: 2rem;
  font-weight: 600;
}

.instagram-link {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  border-radius: 50%;
  width: 60px;
  height: 60px;
  transition: transform 0.2s ease;
  text-decoration: none;
  margin-top: 8px;
}

.instagram-link:hover {
  transform: scale(1.2);
}

.carousel-container {
  margin-top: 40px;
  padding: 0 5px;
}

.carousel {
  border-radius: 20px;
  overflow: hidden;
  transform: scale(0.8);
}
</style>