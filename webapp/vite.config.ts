import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  base: "/rms/",
  build: {
    outDir: "build",
  },
  plugins: [react()],
  resolve: {
    alias: [
      {
        find: '@',
        replacement: new URL('./src', import.meta.url).pathname,
      },
      {
        find: '@assets',
        replacement: new URL('./src/assets', import.meta.url).pathname,
      },
      {
        find: '@components',
        replacement: new URL('./src/components', import.meta.url).pathname,
      },
    ],
  },
})