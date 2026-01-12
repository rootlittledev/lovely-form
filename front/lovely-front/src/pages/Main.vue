<script setup lang="ts">
import { ref, onMounted, onUnmounted } from 'vue'

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

const updateScreenSize = () => {
  const width = window.innerWidth
  const isMac = navigator.platform.toUpperCase().indexOf('MAC') >= 0
  const isWindows = navigator.platform.toUpperCase().indexOf('WIN') >= 0
  
  if (isMac) platform.value = 'Mac'
  else if (isWindows) platform.value = 'Windows'
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
    <div class="mobile-viewport">
      <!-- Profile Image -->
      <div class="text-center" style="margin-top: 80px;">
        <div class="screen-indicator">{{ screenSize }} - {{ platform }}</div>
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
.instagram-link {
  margin-top: 15px !important;
  display: block !important;
}

.carousel {
  border-radius: 20px;
  overflow: hidden;
  transform: scale(0.8);
}

.screen-indicator {
  position: fixed;
  top: 10px;
  right: 10px;
  background: rgba(0,0,0,0.7);
  color: white;
  padding: 5px 10px;
  border-radius: 5px;
  font-size: 12px;
  z-index: 1000;
}

/* Mobile */
@media screen and (max-width: 767px) {
  .mobile-viewport {
    width: 100vw !important;
    height: 100vh !important;
    border-radius: 0 !important;
  }

  .instagram-link {
    margin-top: 15px !important;
    display: block !important;
  }
  
  .bg-brown {
    padding-top: 0 !important;
  }
}

/* Tablet Portrait */
@media screen and (min-width: 768px) and (max-width: 1023px) {
  .mobile-viewport {
    width: 600px !important;
  }

  
  .carousel {
    transform: scale(0.9) !important;
  }
}

/* Tablet Landscape / Small Desktop */
@media screen and (min-width: 1024px) and (max-width: 1199px) {
  .mobile-viewport {
    width: 550px !important;
  }
  
  .instagram-link {
    margin-top: 15px !important;
    display: block !important;
  }
  
  .carousel-container {
    margin-top: -80px !important;
  }
  
  .carousel {
    transform: scale(0.7) !important;
  }
}

/* Desktop */
@media screen and (min-width: 1200px) and (max-width: 1439px) {
  .mobile-viewport {
    width: 500px !important;
  }
  
  .instagram-link {
    margin-top: 20px !important;
  }
  
  .carousel {
    transform: scale(0.7) !important;
  }
}

/* Large Desktop */
@media screen and (min-width: 1440px) and (max-width: 1919px) {
  .mobile-viewport {
    width: 480px !important;
  }
  
  .instagram-link {
    margin-top: 20px !important;
  }
  
  .carousel {
    transform: scale(0.7) !important;
    margin-top: -50px !important;
  }
}

/* Mac-specific adjustments */
@supports (-webkit-backdrop-filter: blur(1px)) {
  @media screen and (min-width: 1440px) and (max-width: 1919px) {
    .carousel {
      transform: scale(0.6) !important;
    }
  }
  
  @media screen and (min-width: 1920px) {
    .carousel {
      transform: scale(0.4) !important;
    }
  }
}

</style>