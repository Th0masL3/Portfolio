import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('http://localhost:3000/consoles');
  await expect(page.getByRole('link', { name: 'carticon' })).toBeVisible();
  await expect(page.getByRole('link', { name: 'carticon' })).toBeVisible();
  await page.getByRole('link', { name: 'carticon' }).click();
  await expect(page.getByRole('heading', { name: 'Your Cart' })).toBeVisible();
});