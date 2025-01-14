import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('http://localhost:3000/');
  await page.getByRole('button', { name: 'Console Icon' }).click();
  await page.getByRole('cell', { name: '675e25d4cad659742f1f91f7' }).click();
  await page.getByRole('cell', { name: '675e25d4cad659742f1f9215' }).click();
});