import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vuetify from 'vite-plugin-vuetify'
import * as path from "path";

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue(), vuetify()],
  base: './',
  server: {
    watch: {
      usePolling: true
    }
  },
    build: {
        outDir: path.resolve(__dirname, '../../src/main/resources/static'),
        emptyOutDir: true
    }
})
