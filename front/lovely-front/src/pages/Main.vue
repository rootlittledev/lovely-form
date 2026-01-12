<script setup lang="ts">
import { ref, onMounted, onUnmounted } from 'vue'
import '../styles/main.css'
import '../styles/mac.css'
import '../styles/windows.css'

const title = "lovelyform"
const images: string[] = [
  '/carousel/image0.jpg',
  '/carousel/image1.jpg',
  '/carousel/image2.jpg',
  '/carousel/image3.jpg',
  '/carousel/image4.jpg',
  '/carousel/image5.jpg'
]
const currentSlide = ref<number>(0)
const screenSize = ref<string>('')
const platform = ref<string>('')
const isMac = ref<boolean>(false)
const isWindows = ref<boolean>(false)

const updateScreenSize = () => {
  const width = window.innerWidth
  isMac.value = navigator.platform.toUpperCase().indexOf('MAC') >= 0
  isWindows.value = navigator.platform.toUpperCase().indexOf('WIN') >= 0
  
  if (isMac.value) platform.value = 'Mac'
  else if (isWindows.value) platform.value = 'Windows'
  else platform.value = 'Linux'
  
  if (width <= 767) screenSize.value = 'Mobile'
  else if (width <= 1023) screenSize.value = 'Tablet Portrait'
  else if (width <= 1199) screenSize.value = 'Tablet Landscape'
  else if (width <= 1439) screenSize.value = 'Desktop'
  else if (width <= 1919) screenSize.value = 'Large Desktop'
  else if (width >= 1920) screenSize.value = 'Extra Large Desktop'
}

onMounted(() => {
  updateScreenSize()
  window.addEventListener('resize', updateScreenSize)
})

onUnmounted(() => {
  window.removeEventListener('resize', updateScreenSize)
})
</script>

<template>
  <v-main class="bg-brown">
    <div class="mobile-viewport" :class="{ 'is-mac': isMac, 'is-windows': isWindows }">
      <!-- Profile Image -->
      <div class="text-center" style="margin-top: 80px;">
        <div class="screen-indicator">{{ screenSize }} - {{ platform }}</div>
        <v-avatar size="100" class="mb-4 avatar">
          <v-img src="/avatar.jpeg" alt="Profile"/>
        </v-avatar>
        <h1 class="profile-title">{{ title }}</h1>
      </div>
      
      <!-- Store Button -->
      <div class="text-center">
        <v-btn 
          color="white"
          variant="outlined"
          size="large"
          class="store-button"
        >
          Go to Store
          <v-icon right class="ml-2">mdi-instagram</v-icon>
        </v-btn>
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
</style>